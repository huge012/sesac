import pymongo

# 1. 물리적으로 DB 서버에(클러스터) 접속, mongoDB 서버
db = pymongo.MongoClient("mongodb://huge:y9e4o0n6@cluster0-shard-00-00.ti8cg.mongodb.net:27017,cluster0-shard-00-01.ti8cg.mongodb.net:27017,cluster0-shard-00-02.ti8cg.mongodb.net:27017/myFirstDatabase?ssl=true&replicaSet=atlas-zdb2pg-shard-0&authSource=admin&retryWrites=true&w=majority")

db_list = db.list_database_names()
# print(type(db_list)) # 파이썬 장점 : 타입 지정 안해도 됨, 단점 : 타입을 확인해야 알 수 있음
# print(db_list) # db의 리스트 보여줌

# 2. target DB를 지정
my_mongo = db.get_database('my_mongo')
mflix = db.get_database(('sample_mflix'))

# print(my_mongo.list_collection_names())

# 3. target Collection을 설정
emps = my_mongo.get_collection('employees')
movies = mflix.get_collection('movies')

# 4. 조회를 수행
emp_list = emps.find()
print(emp_list) # Cursor를 반환해줌.
for emp in emp_list:
    print(emp)

movie_list = movies.find().limit(10)

for movie in movie_list:
    print(movie)


# 주요 파이썬 데이터 타입
# 1. 숫자 int, float, bool(true, false)
# 2. 문자
# 3. list
# 4. dict