class Node:
    def __init__(self,key,value):
        self.value = value
        self.key = key
    def __repr__(self):
        return f'{self.key}:{self.value}'

class Dictionary:
    def __init__(self):
        self.length = 0
        self.dict = []
        for i in range(5):
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
            self.dict[hashed_index].append(Node(key,value))



    def lookup(self,key):
        hashed_index = self.get_hashed_index(key)
        if not self.dict[hashed_index]:
            raise Invalid_key("Invalid Dictionary Key")
        else:
            for i in self.dict[hashed_index]:
                if i.key == key:
                    return i.value
            raise Invalid_key("Invalid Dictionary Key")
    
    def __repr__(self) -> str:
        return str(self.dict)

class Invalid_key(Exception):
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

print(d.lookup('THG'))
print(d.lookup('Amazon'))
