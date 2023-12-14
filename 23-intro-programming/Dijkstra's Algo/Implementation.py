import pandas as pd


class Get_data:
    def __init__(self):
        ...
    
    def get_connections(self):
        df = pd.read_csv('london.connections.csv')
        connection_list = df[['station1','station2','time']].values
        return connection_list

    def get_stations(self):
        df = pd.read_csv('london.stations.csv')
        station_list= df[['id','name']].values
        
        station_dict = {}
        for station in station_list:
            station_dict[station[0]] = station[1]
        return station_dict
        

    def get_lines(self):
        df = pd.read_csv('london.lines.csv')
        ...
        
print(Get_data().get_connections())

class Node:
    def __init__(self,id):
        self.id = id
        self.adjacent = {}
        
    def __str__(self):
        return str(self.id) +" "+ str(self.adjacent)
    
    def __repr__(self):
        return f'Node({self.id})'
    
    def get_connections(self):
        return self.adjacent.keys()
    
    def add_neighbor(self,neighbor,weight = 0):
        self.adjacent[neighbor] = weight

    def get_id(self):
        return self.id
    
    def get_weight(self,neighbor):
        return self.adjacent[neighbor]
    
class Graph:
    def __init__(self):
        self.num_node = 0
        self.node_graph = {}

    def __iter__(self):
        return iter(self.node_graph.values())

    def add_node(self,node):
        self.num_node += 1
        new_node = Node(node)
        self.node_graph[node] = new_node
        return new_node
    
    def add_edge(self, start, end, weight = 0):
        if start not in self.node_graph:
            self.add_node(start)
        if end not in self.node_graph:
            self.add_node(end)

        self.node_graph[start].add_neighbor(self.node_graph[end],weight)
        self.node_graph[end].add_neighbor(self.node_graph[start],weight)
    
    def get_node(self,id):
        if id in self.node_graph:
            return self.node_graph[id]
        else:
            return None
        
    def get_all_nodes(self):
        return self.node_graph

def add_path():
    g = Graph()
    data = Get_data()
    for connection in data.get_connections():
        g.add_edge(connection[0],connection[1],connection[2])
    return g.get_all_nodes()

print(add_path())
        