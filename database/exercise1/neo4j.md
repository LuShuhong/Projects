---
marp: true
theme: thg-accelerator
footer: "![](../../../thg-accelerator-theme/accelerator-logo.svg)"
style: |
  img[alt~="centre"] {
    display: block;
    margin: 0 auto;
  }
---

# Neo4j Graph Database

---

## Background

2000: Development begins as the co-founders were working on a content-management system and couldn't solve a problem with relational databases so they came up with the property graph model (combines best of graphs and relational databases by combining focus on relationships between nodes with possibility to add properties to both)
![image of property graph](property_graph.png)
2003: Their fist graph database was in 24/7 production
2007: First native graph database (storing the relationships directly rather than indirectly through joins; will explain in more detail in design and architecture section); Neo4j1.0 released as open source and commercial package
2011: Cypher launched as first declarative language designed to query property graphs
2013: Model extended to 'labelled' property graph to allow for easy lookup and creating of groups that go together

### Originally written to support near realt-ime online transactional processing, but focus gradually shifted to also include strong capabilities around analytical processing to support more complex data anlysis, so now generally belongs in category of hybrid transaction and analytics processing systems

---

## Design and Architecture

---

### Overview of Neo4j ecosystem

![Overview of Neo4j ecosystem](neo4k-architecture-diagram.svg)

**cypher query language** Designed by Neo4j to be used to query graph databases (now used by some other databases as well). Similar to SQL but optimized for graphs. Based on English prose and iconography, making queries eay to write and read
`(nodes) - [:ARE_CONNECTED_TO] -> (otherNodes)`

**neo4j Aura** cloud version of Neo4j database, fully managed updates and patches (no interruption to service), ACID compliant, robust security and reliability; built-in tools for learning, building and visualising

**Analytics** Graph data science, software component whose main purpose is to run graph algorithms on in-memory projects of Neo4j database data, including ML modelling.

**Neo4j tools** Includes wide range of tools, such as:

- a browser client which can interact with the database,
- an ops manager that enables administrators to monitor, administer and operate all of the Neo4j Databases
- cypher shell, a CLI that can run queries and perform administrative tasks against a Neo4j instance
- Kubernetes helm charts, to help deploy and manage the Neo4j databse on kubernetes

**Visualization** Bloom is their visualisation tool which allows to quicly explore and freely interact with Neo4js graph data platform - with no coding required
[Bloom platofmr](https://workspace-preview.neo4j.io/workspace/query)

**Drivers and API connectors** Wide variety of APIs, drivers, libraries and plugins that help connect neo$j to other frameworks, languages, etc. They can be either produced and maintained by Neo4j itself, or community-contributed

---

### Overview of Neo4j ecosystem

![Overview of Neo4j ecosystem](neo4k-architecture-diagram.svg)

**cypher query language** Designed by Neo4j to be used to query graph databases (now used by some other databases as well). Similar to SQL but optimized for graphs. Based on English prose and iconography, making queries eay to write and read
`(nodes) - [:ARE_CONNECTED_TO] -> (otherNodes)`

**neo4j Aura** cloud version of Neo4j database, fully managed updates and patches (no interruption to service), ACID compliant, robust security and reliability; built-in tools for learning, building and visualising

**Analytics** Graph data science, software component whose main purpose is to run graph algorithms on in-memory projects of Neo4j database data, including ML modelling.

**Neo4j tools** Includes wide range of tools, such as:

- a browser client which can interact with the database,
- an ops manager that enables administrators to monitor, administer and operate all of the Neo4j Databases
- cypher shell, a CLI that can run queries and perform administrative tasks against a Neo4j instance
- Kubernetes helm charts, to help deploy and manage the Neo4j databse on kubernetes

**Visualization** Bloom is their visualisation tool which allows to quicly explore and freely interact with Neo4js graph data platform - with no coding required
[Bloom platofmr](https://workspace-preview.neo4j.io/workspace/query)

**Drivers and API connectors** Wide variety of APIs, drivers, libraries and plugins that help connect neo$j to other frameworks, languages, etc. They can be either produced and maintained by Neo4j itself, or community-contributed

---

**Data storage**
![general query architecture](query_architecture.webp)
_transporter_ a client query arrives through a transport subsystem which hands it over to a query processor
_query processor_ parser interprets, validates and optimises (i.e. finding most efficient way to process and retrieve data) the query. The Cypher query planner bases optimisation on internl statistics, indexes, constrains, data placement etc and decomposes a query into operators, which are combined into a tree-like structure that forms the execution plan
_execution engine_ performs execution plan and aggregates the results. The leaf nodes of the tree-like structure resolve into records, and the output is then piped back up the tree. Non-leaf nodes require sub-selection output set from the upstream branches. It is possible to configure and fine-tune the execution plan manually if you know what you're doing.

![Indexing of nodes and relationshiops](index-free-adjacency-in-Neo4j.webp)
Neo4j uses index-free adjacency to organise data records on disk. This means that rather than mapping record keys to a location on a disk (which can take up significant disk space for large databases and impact write performance), every node references its adjacent or next node directly. Each node is stored as a singly-linked list and the referenceing to the next node functions as a micro-index stored in the node itself.
Edges are stored as doubly-linked lists, which means they store a reference to both the preceding node (start point) and the next node (end point). This means that processing occurs at a constant rate regardless of data size, rather than traditional indexing which takes longer as the data grows.
![distrubution of nodes and relationships acorss bytes](storage_in_bits.webp)
This way of storing the graph (storing both the nodes and the relationships directly and use index-free adjacency) are what make Neo4j a **native** graph database. Many other graph databases make use of a graph-abstraction on top of another technology to store its data, meaning they are not as efficient as the relationships still have to be created while the query is performed (e.g. via join operations).

---

_lookup and traversal_

1. Lookup request moves the pointer to the first record in the global index
2. Computes in bytes the offset by multiplying the starting node (or other object) byte size or relationship ID byte size by the node store record size to find the starting node address
3. Then also looks up the byte size address(es) for related edges and properties in the lookup request
   By referencing data in memory and directly by using pointers, and by iterating over linked lists of the various objects (e.g. nodes and edges) moving from pointer to pointer (which is called referencing in Java, and what Neo4j calls chasing pointers), it reduces the number of actual disk reads required of a query

The only more traditional indexing that is default in Neo4j is the ==token lookup index==. This is created for all node labels and relationship types. This enables matching a node through its lable, which avoids scanning and filtering all the node labels. They also speed up the population of other indexes.

## Other optional indexes are: range, point, text and full-text. These are created and dropped as needed and provide a mapping from a property value to a node or relationships. Cypher's query planner automatically decides whic of the available indexes to use (though it can be configure by the user)

**physical storage**
Data stored on physical disk is stored according to the index-free adjacency principle. A Graph is structured in a set of files, known as store files, that are generally broken down by record type
![physcial storage of a graph on disk](physical_storage.webp)
It relies heavily on memory for caching disk contents for performance or as temporary storage

**scaling**
The cloud version offers architecture that scales with your data needs and minimizes infrastructure costs while maximizing performce across connected datasets. Autonomous clustering lets you horizontally scale out your data while taking advantage of infrastructure elasticity, with less manual effort. You can also scale out very large graphs across multiple databases while maintaining query simplicity and performance
_Atonomous clustering_
![autonomous clustering](Autonomous-Clustering.svg)
architecture automatically allocates copies to the optimal servers based on default business rules or specified operations requirements

## Useful when throughput demand for the same dataset arises

_Sharding_
![sharding](Sharding.svg)
Neo4j scales out as data grows with sharding. This technique divides a single logical database into several smaller databases (shards). Running your shard on autonomous clusters allows you to achieve unlimited horizontal scalability for a very large graph

Useful as the size of your graph grows

For graphs that are highly connected there will be some level of data redundancy (duplication) to maintain relationships between entities

1[Composite database federation using fabric](Composite-Database-Federation-using-Fabric.svg)
If you shard your database, how do you treat it as a cohesive whole?

Fabric architecture
brings the shards together to quickly create a composite database that contains a graph of all your remote graphs. This allows you to perform a federated query across the entire graph via the composite database
federated query: sends a query statement to a composite database and gets the result back as a temporary table. It is a collection of features that enable users and systems to run queries against multiple datasources whithout needing to migrate all data to a unified system
Queries coming from users or applications will hit the fabric database first, then get routed to the instance or instances required to answer the query. The answers from each involved graph are sent back to the fabric database, where they are aggregated or filtered into a unified result that is sent back to the requesting party.

---

**cluster support**
Though one of the early criticism of Neo4j, later editions offer extensive cluster support via causal clustering. It facilitates a single unit of servers (cluster) to maintain its state across replicas, even when communication may be interrupted. Applies:

- causal consistency: concurrent writes are applied in the same order that they occur by looking at the order causally related operations are processed. Uses transaction IDs to determine how far (in transaction number) a follower is behind its leader Ensures a **read-your-writes** consistency: https://docs.oracle.com/cd/E17076_05/html/gsg_db_rep/C/rywc.html (Follower keeps track how consistent they are with a Leader copy, if determined a copy is not consistent enough, developer can specify action to be taken (e.g. reroute to different server that is consistent enough, block the read, reject the request outright, etc)).
- consensus algorithm: relies on the Raft protocol: https://thesecretlivesofdata.com/raft/. This handle the election of the leader copy and how to maintain a consistent log across the cluser.

---

## Position in the CAP Model

Neo4j aligns with the **Consistency and Partition Tolerance** aspects of the CAP theorem. [More details](https://www.geeksforgeeks.org/the-cap-theorem-in-dbms/)

[What about this](https://neo4j.com/blog/recap-intro-to-graph-databases-webinar-series-1/)

- **Consistency**: Neo4j ensures that all database clients see the same data at the same time, maintaining a high level of data accuracy.
- **Partition Tolerance**: It can function across a distributed network, ensuring continuous operation despite possible node failures.

The trade-off is in terms of Availability in some scenarios, where the system may sacrifice immediate data availability to maintain consistency.

---

- Neo4j aura designed to be always on and available, with all corrections, fixes, and upgrades automatically applied in the background. Releases for the Neo4j database are also deployed when they become available. Operations are non-disruptive, and you shouldn't experience downtime as a result
- You can also scale out very large graphs across multiple databases while maintaining query simplicity and performance
- Read-your writes level of consistency https://docs.oracle.com/cd/E17076_05/html/gsg_db_rep/C/rywc.html (copies track how consistent they are with a master copy, if determined a copy is not consistent enough, developer can specify action to be taken (e.g. reroute to different server that is consistent enough, block the read, reject the request outright, etc.))

---

## Use Cases

Neo4j finds applications across various domains, offering solutions for complex data relationships:

---

### 1. Social Networks Analysis

- _User Connection Insights_: Mapping intricate social connections to provide deep insights into user relationships, community formation, and influence patterns.
- _Tailored Content Delivery_: Analysing user preferences and interactions to deliver personalised content, thus enhancing user engagement and experience.

---

### 2. Recommendation Engines

- _E-Commerce Personalisation_: Utilising customer purchase history and preferences to suggest relevant products, thereby increasing sales and customer satisfaction.
- _Media and Content Recommendations_: Empowering streaming services to suggest films, shows, or music based on user behaviour, enhancing personalised user experiences.

---

### 3. Fraud Detection in Financial Services

- _Pattern Recognition_: Identifying unusual patterns to detect fraudulent activities in real-time, crucial for financial institutions.
- _AML (Anti-Money Laundering)_: Playing a key role in uncovering complex money laundering schemes through transaction network analysis.

---

### 4. Network and IT Operations

- _Infrastructure Management_: Aiding in visualising and managing network infrastructures, thus improving efficiency in issue identification and resolution.
- _Security Analysis_: Employed for detecting vulnerabilities and intrusion attempts by analysing network traffic patterns.

---

## Pros and Cons of Neo4j

---

### Pros

#### Highly Intuitive for Connected Data

- _Deep Link Analysis_: Facilitates in-depth analysis of relationships and interconnections, crucial in domains like social network analysis and recommendation systems.

#### Flexible Schema

- _Adaptability_: Neo4j's schema adapts easily to changing data structures, essential in dynamic sectors like e-commerce and digital marketing.

#### Powerful Query Language - Cypher

- _Efficient Data Retrieval_: The expressiveness of Cypher simplifies complex queries, enhancing data analysis and retrieval efficiency.

---

### Cons

#### Learning Curve

- _Specialised Knowledge Required_: Mastery of graph databases and Cypher entails a learning curve, potentially challenging for teams more familiar with SQL or traditional databases.

#### Scalability Challenges

- _Handling Large-Scale Data_: Although improving, Neo4j faces challenges in managing extremely large datasets and ensuring performance at scale, especially when compared to certain other NoSQL databases.

#### Resource Intensity

- _High Memory Requirements_: Managing large graphs demands significant memory resources, which can escalate operational costs.

---

## Resources

- [Getting Started with Neo4j](https://neo4j.com/developer/get-started/)
