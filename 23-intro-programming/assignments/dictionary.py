class Node:
    def __init__(self,key,value):
        self.value = value
        self.key = key
    def __repr__(self):
        return f'{self.key}:{self.value}'

class Dictionary:
    def __init__(self,capacity = 2,load_factor = 2):
        self.length = 0
        self.dict = []
        self.capacity = capacity
        self.load_factor = load_factor
        for i in range(capacity):
            self.dict.append([])

    def get_hashed_index(self,key):
        hashed_key = hash(key)
        hashed_index = hashed_key % len(self.dict)
        return hashed_index

    def insert(self,key,value):
        hashed_index = self.get_hashed_index(key)
        for i in self.dict[hashed_index]:
            if i.key == key:
                i.value = value
                break
        else:
            if self.length/self.capacity>self.load_factor:
                self._resize()
            self.dict[hashed_index].append(Node(key,value))
            self.length += 1



    def lookup(self,key):
        hashed_index = self.get_hashed_index(key)
        if not self.dict[hashed_index]:
            raise InvalidKey("Invalid Dictionary Key")
        else:
            for i in self.dict[hashed_index]:
                if i.key == key:
                    return i.value
            raise InvalidKey("Invalid Dictionary Key")
        
    def delete(self, key):
        hashed_index = self.get_hashed_index(key)
        if not self.dict[hashed_index]:
            raise InvalidKey("Invalid Dictionary Key")
        else:
            for i,node in enumerate(self.dict[hashed_index]):
                if node.key == key:
                    del self.dict[hashed_index][i]
                    self.length -= 1
                    return
            raise InvalidKey("Invalid Dictionary Key")
        

    def _resize(self):
        self.capacity = self.capacity *2
        new_dict = [[] for i in range(self.capacity)]
        for i in self.dict:
            for j in i:
                hashed_index = hash(j.key)%(self.capacity)
                new_dict[hashed_index].append(Node(j.key,j.value))
        self.dict = new_dict

    def __repr__(self) -> str:
        return str(self.dict)

class InvalidKey(Exception):
    pass
    
d = Dictionary()
d.insert('Apple',3000)
d.insert('Microsoft',2800)
d.insert('Alphabet',1800)
d.insert('Amazon',1600)
d.insert('Nvidia',1000)
d.insert('Tencent',600)
d.insert('Alibaba',400)
d.insert('Arms',50)
d.insert('THG',1)
print(d)
# print(d.lookup('THG'))
# print(d.lookup('Amazon'))
