import pymongo
db = pymongo.MongoClient("mongodb://huge:y9e4o0n6@cluster0-shard-00-00.ti8cg.mongodb.net:27017,cluster0-shard-00-01.ti8cg.mongodb.net:27017,cluster0-shard-00-02.ti8cg.mongodb.net:27017/myFirstDatabase?ssl=true&replicaSet=atlas-zdb2pg-shard-0&authSource=admin&retryWrites=true&w=majority")

people = db.get_database('mymongo_db').get_collection('people')

result = people.update_many(
    { 'age': { '$gt': 40 } },
    { '$set': {'status': 'C'}}
)
print(result)