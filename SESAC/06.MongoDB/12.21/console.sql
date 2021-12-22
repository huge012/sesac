use commerce

db.prodects.find()

db.prodects.insertOne({
    id: 3,
    name: '갤럭시 노트 20',
    price: 9000,
    discount_rate: 3,
})

// commerce db 사용
// users 컬렉션 사용
// 사용자 데이터 insert

use commerce
db.createCollection('users')

db.users.insertOne({
    name: 'kim',
    dateOfBirth: new Date(1973,2,5),
    placeOfBirth: 'Seoul',
    profession: 'doctor',
    hobbies: [
        'painting', 'Listen to music', 'climbing',
    ],
    address: {
        city: 'seoul',
        country: 'korea',
        postcode: 11223,
    }
})

db.users.insertOne({
    name: 'Helen',
    dateOfBirth: new Date(2007, 12, 5),
    placeOfBirth: 'Brisbane',
    profession: 'Student',
    hobbies: [      // array
        "painting",
        "football",
        "singing",
        "story-writing",
    ],
    address: {      // field
        city: 'Sydney',
        country: 'Australia',
        postcode: 2161,
    }
})

db.users.find()

db.users.deleteOne({placeOfBirth: null})  // 데이터 삭제

db.users.insertOne({
    name: 'Owen',
    dateOfBirth: new Date(1900, 12, 5),
    // placeOfBirth: 'NewYork',
    profession: 'Student',
    hobbies: [      // array
        "painting",
        "football",
        "working",
        "story-writing",
    ],
    address: {      // field
        city: 'NewYork',
        country: 'USA',
        postcode: 25151,
    }
})

// 데이터 업데이트
db.users.updateOne(
    {name: 'Owen'},
    {$set:{'placeOfBirth': 'LA'}},
)

use sample_mflix

db.movies.find()

db.movies.findOne() // 순서에 따라 하나 가져옴

db.movies.find({}) // 조건이 없어서 전체보기와 동일

db.movies.findOne({
    countries: 'USA'
})

db.movies.find({
    cast: 'Douglas Fairbanks'
})

db.movies.find({
    genres: 'Fantasy',
})

db.movies.find({
    year: 2016
}).pretty()

// select cast, contries from movies where year = 2016
db.movies.find(
    {year: 2016},
    {cast: 1, contries: 1},
)

db.movies.find()

// select distinct('countries') from movies
db.movies.distinct('countries')

// select * from movies where countries = 'South Korea'
db.movies.find(
    {
        countries:'South Korea'
    }
).count()

db.movies.distinct(
    'genres'
).length


// select distinct('genre') from movies where countries = 'South Korea';
db.movies.distinct(
    'genres',
    {countries: 'South Korea'}
).length


db.movies.find({num_mflix_comments: 5})
db.movies.find({num_mflix_comments: {$eq:5}})

db.movies.find({
    "num_mflix_comments": {$ne: 5}
})

db.movies.find({
    year: {$gte: 2015}
}).count()

db.movies.find({released: {$gte: new Date('2000-01-01')}}).count()

db.movies.find({
    num_mflix_comments: {$lt: 2}
}).count()

db.movies.find({
    released: {$lt: new Date('2000-01-01')}
}).count()

db.movies.find({
    rated: {$in : ['G', 'PG', 'PG-13']}
})

db.movies.find()

db.movies.find({
    cast: { $eq: "Leonardo DiCaprio" }
})

db.movies.distinct(
    'genres',
    {cast: "Leonardo DiCaprio"}
).length

db.movies.find(
    {cast: "Leonardo DiCaprio"},
    {title: 1, year: 1, "_id": 0}
)

db.movies.find(
    {cast: /Leonardo/},
    {title: 1, year: 1, _id: 0}
)

db.movies.countDocuments(
    { directors: "Leonardo DiCaprio" }
)

db.movies.countDocuments(
    { $and: [{rated: "UNRATED"}, {year: 2008}] }
)

db.movies.countDocuments(
    { rated: "UNRATED", year: 2008 }
)

db.movies.find(
{
    $or: [
        {rated : "G"},
        {rated : "PG"},
        {rated : "PG-13"}
    ]}
)

db.movies.find(
    { $or: [
        {rated: "G"},
        {year: 2005},
        {num_mflix_comments: {$gte: 5}}
    ]}
)

db.movies.find(
{
    $nor: [
        {rated: "G"},
        {year: 2005},
        {num_mflix_comments: {$gte: 5}}
    ]}
)

db.movies.find(
    { num_mflix_comments: {$gte: 5} }
)

db.movies.find(
    { "num_mflix_comments": {$not: {$gte: 5}} }
)

db.movies.find(
    {
        cast: "Leonardo DiCaprio",
        directors : "Martin Scorsese",
        $or: [{genres: "Drama"}, {genres:"Crime"}]
    },
    {
        title:1, year:1, _id:0
    }
)

db.movies.find(
    {
        $and: [
            {cast: 'Leonardo DiCaprio'},
            {directors: 'Martin Scorsese'},
            {
                $or: [
                    {genres: "Drama"},
                    {genres: "Crime"}
                ]
            }
        ]
    },
    {
        title:1, year:1, _id:0
    }
)

db.movies.find(
    { cast: {$regex: '^Leonardo'} },
    { _id:0, cast:1, title:1 }
)

db.movies.find(
{
    $or: [
            {rated: 'G'},
            {year: 2005},
            {num_mflix_comments: {$gte: 2}},
        ]
    }
)