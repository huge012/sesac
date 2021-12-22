
use mymongo_db

db.people.insertOne(
     { user_id: "bcd001", age:45,status:"A" }
)
db.people.find()

db.people.insertMany([
    { user_id: "bcd002", age:25,status:"B" },
    { user_id: "bcd003", age:50,status:"A" },
    { user_id: "bcd004", age:35,status:"A" },
    { user_id: "abc001", age:28,status:"B" }
])
//- SELECT * FROM people
db.people.find()

//- SELECT _id, user_id, status FROM people
db.people.find(
    { },
    { user_id: 1, status: 1}
)
db.people.find({ }, { user_id: 1, status: 1 })


//- SELECT user_id, status FROM people
db.people.find(
    {},
    {user_id: 1, status: 1, _id: 0}
)
db.people.find({ },{ user_id: 1, status: 1, _id: 0 })

//- SELECT * FROM people WHERE status = 'A'
db.people.find(
    {
        status: 'A'
    }
)
db.people.find({ status: "A" })

//- SELECT user_id,status from people where status = 'A'
db.people.find(
    {
        status: 'A'
    },
    {
        user_id: 1,
        status: 1,
        _id: 0
    }
)
db.people.find({ status: "A" },{ user_id:1, status:1,_id:0})

//- SELECT * from people where status != 'A'
db.people.find(
    {
        status: {$ne:'A'}
    }
)
db.people.find({ status: { $ne:"A" }})

//- SELECT user_id, status, age FROM people where user_id != 'abc001'
db.people.find(
    {
        user_id: {$ne: 'abc001'}
    },
    {
        user_id: 1,
        status: 1,
        age: 1,
        _id: 0
    }
)
db.people.find({user_id:{$ne:'abc001'}},{user_id:1,status:1,age:1,_id:0})

//- SELECT * FROM people WHERE status = 'A' AND age = 50
db.people.find(
    {
        status: 'A',
        age: 50
    }
)
db.people.find({ status: "A", age: 50 })

//- SELECT * FROM people WHERE status = "A" OR age = 50
db.people.find(
    {
        $or: [
            { status: 'A' },
            { age: 50 }
        ]
    }
)
db.people.find({ $or: [ { status: "A" } , { age: 50 } ] })

//- SELECT * FROM people WHERE age > 25
db.people.find(
    {
        age: {$gt: 25}
    }
)
db.people.find({ age: { $gt: 25 } })

//- SELECT * FROM people WHERE age < 25
db.people.find(
    {
        age: {$lt: 25}
    }
)
db.people.find({ age: { $lt: 25 } })

//- SELECT * FROM people WHERE age > 25 AND age <= 50
db.people.find(
    {
        age: {$gt: 25, $lte: 50}
    }
)
db.people.find({ age: { $gt: 25, $lte: 50 } })

//- SELECT * FROM people WHERE age in (25,15)
db.people.find(
    {
        age: {$in: [15, 25]}
    }
)
db.people.find( { age: { $in: [ 25, 15 ] } } )

//- SELECT * FROM people WHERE age not in (5,15)
db.people.find(
    {
        age: {$nin: [5, 15]}
    }
)
db.people.find( { age: { $nin: [ 5, 15 ] } } )

//- SELECT * FROM people WHERE user_id like "%cd%"
db.people.find(
    {
        user_id: { $regex: /cd/ }
    }
)
db.people.find( { user_id: { $regex: /cd/ } } )

//- SELECT * FROM people WHERE user_id like "bc%"
db.people.find(
    {
        user_id: {$regex: /^bc/}
    }
)
db.people.find( { user_id: { $regex: /^bc/ } } )

//- SELECT * from people where user_id like "%01"
db.people.find(
    {
        user_id: {$regex: /01$/}
    }
)
db.people.find({user_id:{$regex:/01$/}})

//- SELECT * FROM people WHERE status = "A" ORDER BY user_id ASC
db.people.find(
    {
        status: 'A'
    }
).sort( { user_id: 1 } )
db.people.find( { status: "A" } ).sort( { user_id: 1 } )

//- SELECT * FROM people WHERE status = "A" ORDER BY user_id DESC
db.people.find(
    {
        status: 'A'
    }
).sort({user_id: -1})
db.people.find( { status: "A" } ).sort( { user_id: -1 } )

//나이:40 초과, user_id: cd 포함 , user_id와 age, _id만 보여줌, user_id 오름차순으로
db.people.find(
    {
        age: {$gt: 40},
        user_id: {$regex: /cd/}
    },
    {
        user_id: 1,
        age: 1,
    }
).sort( { user_id: 1 } )
db.people.find({age:{$gt:40},user_id:{$regex:/cd/}},{user_id:1,age:1}).sort({user_id:1})

db.people.find()

// status A, B이며, 나이는 25세 이상 45세 이하, user_id와 status와 age만 보여줌
db.people.find(
    {
        status: { $in: ['A', 'B'] },
        age: {$gte: 25, $lte: 45},
    },
    {
        user_id: 1,
        status: 1,
        age: 1,
        _id: 0
    }
)
db.people.find({status:{$in:['A','B']},age:{$gte:25,$lte:45}},{_id:0,user_id:1,status:1,age:1})

//- SELECT COUNT(*) FROM people
db.people.count()
db.people.count()

//- select count(*) from people where age > 30
db.people.count(
    {
        age: {$gt: 30}
    }
)
db.people.count({ age : { $gt:30 }})

//- SELECT COUNT(user_id) FROM people : user_id 컬럼의 값이 존재하는 row count
db.people.count(
    {
        user_id: {$exists: true}
    }
)
db.people.count( { user_id: { $exists: true } } )

//- SELECT DISTINCT(status) FROM people
db.people.distinct('status')

// 같은 상태끼리 그룹화해서 _id 지정해줌
db.people.aggregate( [{ $group : {_id: "$status" }}] )

// 나이가 20 초과인 사람 1명을 보여줌
db.people.findOne({age:{$gt:20}})

//- SELECT * FROM people LIMIT 1
db.people.find().limit(1)
db.people.find().limit(1)

// 전체중 1사람은 건너뛰고 3명 보여줌
db.people.find().limit(3).skip(1)
db.people.find().limit(3).skip(1)

//- UPDATE people SET status = "C" WHERE age > 45
db.people.updateMany(
    {
        age: { $gt: 45 }
    },
    {
        $set: { status: 'C' }
    }
)
db.people.updateMany( { age: { $gt: 45 } }, { $set: { status: "C" } } )

// 1개의 Document만 수정하려면 updateOne을 사용함
db.people.updateOne(
    {
        age: { $gt: 25 },
    },
    {
        $set: { status: 'D' }
    }
)
db.people.updateOne( { age: { $lte: 25 } }, { $set: { status: "D" } } )

//- UPDATE people SET age = age + 3 WHERE status = "A"
db.people.updateMany(
    {
        status: 'A'
    },
    {
        $inc: { age: 3 }
    }
)
db.people.updateMany( { status: "A" } , { $inc: { age: 3 } } )

//- DELETE FROM people WHERE status = "D"
db.people.deleteMany(
    {
        status: 'D'
    }
)
db.people.deleteMany( { status: "D" } )

//- DELETE FROM people
db.people.deleteMany({})

db.people.updateMany(
   { user_id: "bcd001" },
   { $unset: { status: "", age: 0 } }
)

db.people.find()

//Provides information on the query plan for the db.collection.find() method.
db.people.find().explain()