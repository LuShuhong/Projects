text = open('shakespeare.txt')
shakes = open('shakespeare.txt')
text = shakes.read().split()
type(text)
len(text)
text[1:20]

#longest word

def find_longest_word(text):
    longest_word = text[0]
    longest_word_length = len(longest_word)
    for i in range(0,len(text)):
        if len(text[i]) > longest_word_length:
            longest_word_length = len(text[i])
            longest_word = text[i]
    
    return longest_word

#longest palidrome

def find_longest_palidrome():
    palidrome_list = []
    for i in text:
        if i == i[::-1]:
            palidrome_list.append(i)

    return find_longest_word(palidrome_list)

