class Node:
    def __init__(self,value,next=None,prev=None):
        self.value = value
        self.next = next
        self.prev = prev

    def __repr__(self):
        return f'Node({self.value})'

class Deque:
    def __init__(self):
        self.length = 0
        self.front = None
        self.rear = None

    def __repr__(self):
        return f'Deque start:{self.front} end:{self.rear} length:{self.length}'
        

    def insert_front(self,value):
        new_node = Node(value)

        if self.length == 0:
            self.front = self.rear = new_node
        else:
            self.front.prev = new_node
            new_node.next = self.front
            self.front = new_node
        
        self.length += 1

    def insert_back(self,value):
        new_node= Node(value)
        if self.length == 0:
            self.front = self.rear = new_node
        else: 
            self.rear.next = new_node
            new_node.prev = self.rear
            self.rear = new_node
        self.length += 1

    def remove_front(self):
        if self.length == 0:
            raise IndexError("Empty Deque")
        
        popped = self.front.value
        if self.length == 1:
            self.rear = self.front = None
            
        else:
            new_front= self.front.next
            new_front.prev = None
            self.front.next = None
            self.front = new_front

        self.length -= 1
        return popped
    
    def remove_rear(self):
        if self.length == 0:
            raise IndexError("Empty Deque")
        
        popped = self.rear.value
        if self.length == 1:
            self.rear = self.front = None
            
        else:
            new_rear= self.rear.prev
            new_rear.next = None
            self.rear.prev = None
            self.rear = new_rear
        self.length -= 1
        return popped
    
    def peek_front(self):
        if self.length == 0:
            return "empty deque"
        return self.front.value
    
    def peek_rear(self):
        if self.length == 0:
            return "empty deque"
        return self.rear.value
    
d = Deque()
d.insert_front(1)
print(d)
d.insert_back(100)
print(d)
d.insert_back(99)
d.insert_front(2)
print(d)
d.remove_front()
print(d)
d.remove_rear()
print(d)
print(d.peek_front())
print(d.peek_rear())
