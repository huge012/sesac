import pymongo

# list

favorite_colors = {'red', 'blue', 'black', 'white'}

# print(favorite_colors(0))

for item in favorite_colors:
    print(item.upper())


# dict - 딕셔너리 : key값으로 접근

article = {
    'title': '오늘은 좋은날',
    'content': 'good ok...',
    'author': {
        'name': 'kim',
        'age': 40,
        'addr': 'seoul'
    },
    'likes': 30,
    'tags': ['good', 'today', 'python']
}

print(article['author']['age'])
print(article['tags'][1])
