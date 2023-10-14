text = open('shakespeare.txt')
shakes = open('shakespeare.txt')
text = shakes.read().split()
type(text)
len(text)
text[1:20]

word_dict={}
#longest word

def longest_word(text):
    longest_word = text[0]
    longest_word_length = len(longest_word)
    for i in range(0,len(text)):
        if len(text[i]) > longest_word_length:
            longest_word_length = len(text[i])
            longest_word = text[i]
    
    return longest_word

#longest palidrome

def longest_palidrome():
    palidrome_list = []
    for i in text:
        if i == i[::-1]:
            palidrome_list.append(i)

    return longest_word(palidrome_list)

def most_common_word():
    for i in text:
        if not i in word_dict:
            word_dict[i] = 1
        word_dict[i] += 1


    return max(word_dict,key = lambda k: word_dict[k])

def uniq_words():
    most_common_word()
    return len(word_dict)
