# use sample_mflix
# db.movies.find({countries: 'South Korea'})

import pymongo

# 1. 물리적으로 DB 서버에(클러스터) 접속, mongoDB 서버
db = pymongo.MongoClient("mongodb://huge:y9e4o0n6@cluster0-shard-00-00.ti8cg.mongodb.net:27017,cluster0-shard-00-01.ti8cg.mongodb.net:27017,cluster0-shard-00-02.ti8cg.mongodb.net:27017/myFirstDatabase?ssl=true&replicaSet=atlas-zdb2pg-shard-0&authSource=admin&retryWrites=true&w=majority")

movies = db.get_database('sample_mflix').get_collection('movies')

# 1. movies 찾을 때 뽑아내기
result = movies.find({'countries' : 'South Korea'}, {'title': 1, '_id': 0})
for movie in result:
    print(movie)

print("--------")
result = movies.find({ 'countries' : 'South Korea' })

cnt = 0
for movie in result:
    cnt += 1
    print(movie['title'])

print(cnt)


print("--------")

# 2010년도 이후에 나온 한국영화를 타이틀만 출력
import datetime
result = movies.find({ 'countries' : 'South Korea'})

cnt = 0
for movie in result:
    if(movie['released'] >= datetime.datetime(2010,1,1)):
        print(movie['title'])
        cnt+=1

print(cnt)