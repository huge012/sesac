//1. mymongo_db 생성
use mymongo_db
//2. employees 컬렉션 생성
db.employees.find()
//3. employees 컬렉션 확인
show dbs
//4. employees 컬렉션 statistics 확인
db.employees.find().explain()

//5.document 추가 insertMany() 사용
/*
  {"number":1001,"last_name":"Smith","first_name":"John","salary":62000,"department":"sales", hire_date:ISODate("2016-01-02")},
  {"number":1002,"last_name":"Anderson","first_name":"Jane","salary":57500,"department":"marketing", hire_date:ISODate("2013-11-09")},
  {"number":1003,"last_name":"Everest","first_name":"Brad","salary":71000,"department":"sales", hire_date:ISODate("2017-02-03")},
  {"number":1004,"last_name":"Horvath","first_name":"Jack","salary":42000,"department":"marketing", hire_date:ISODate("2017-06-01")},
*/
db.employees.insertMany([
    {"number":1001,"last_name":"Smith","first_name":"John","salary":62000,"department":"sales", hire_date:ISODate("2016-01-02")},
    {"number":1002,"last_name":"Anderson","first_name":"Jane","salary":57500,"department":"marketing", hire_date:ISODate("2013-11-09")},
    {"number":1003,"last_name":"Everest","first_name":"Brad","salary":71000,"department":"sales", hire_date:ISODate("2017-02-03")},
    {"number":1004,"last_name":"Horvath","first_name":"Jack","salary":42000,"department":"marketing", hire_date:ISODate("2017-06-01")},
])


//6.document select all
db.employees.find()

//7.SELECT * FROM employees WHERE department='sales';
db.employees.find(
    {
        department: 'sales'
    }
)

//8.select * from employees where hire_date > "2017-01-01"
db.employees.find(
    {
        hire_date: {$gt: new Date('2017-01-01')}
    }
)

//9.select number,last_name,first_name from employees
db.employees.find(
    {},
    {
        number: 1,
        last_name: 1,
        first_name: 1,
        _id: 0
    }
)

//10.select number,last_name,first_name from employees where number=1003
db.employees.find(
    {
        number: 1003
    },
    {
        number: 1,
        last_name: 1,
        first_name: 1,
        _id: 0
    }
)

//11.select * from employees where number = 1001 and department = 'sales'
db.employees.find(
    {
        number: 1001,
        department: 'sales'
    }
)

//12.select * from employees where number = 1002 or department = 'sales'
db.employees.find(
    {
        $or: [
            { number: 1002 },
            { department: 'sales' }
        ]
    }
)

//13.select * from employees where number in (1001,1003)
db.employees.find(
    {
        number: { $in: [ 1001, 1003 ] }
    }
)

//14.select * from employees where number not in (1001,1003)
db.employees.find(
    {
        number: { $nin: [1001, 1003] }
    }
)

//15.select * from employees where last_name like '%e%'
db.employees.find(
    {
        last_name: {$regex: /e/}
    }
)

//16.select * from employees where firs_name like '%a%'
db.employees.find(
    {
        first_name: { $regex: /a/ }
    }
)

//17.select * from employees where first_name like 'B%'
db.employees.find(
    {
        first_name: {$regex: /^B/}
    }
)

//18.select * from employees where last_name like '%h'
db.employees.find(
    {
        last_name: { $regex: /h$/ }
    }
)

//19.select * from employees order by department
db.employees.find().sort({ department: 1 })

//20.select * from employees order by hire_date desc
db.employees.find().sort({ hire_date: -1 })

//21.select count(*) from employees
db.employees.count()

//db.employees.find().count() 않됨

//23.insertOne
//insert into employees (number,last_name,first_name,salary,department,status) values (1005,'Hong','Gildong',55000,'clerk','A')
//insert into employees (number,last_name,first_name,salary,department,status) values (1006,'박','둘리',50000,'clerk','B')
db.employees.insertOne({
    number: 1005,
    last_name: 'Hong',
    first_name: 'Gildong',
    salary: 55000,
    department: 'clerk',
    status: 'A'
})
db.employees.insertOne({
    number: 1006,
    last_name: '박',
    first_name: '둘리',
    salary: 50000,
    department: 'clerk',
    status: 'B'
})

//24.select * from employees where status = 'A'
db.employees.find(
    {
    status: 'A'
    }
)

//25.select * from employees where status in ('A','B)
db.employees.find(
    {
        status: { $in: ['A', 'B'] }
    }
)

//26.status column이 존재하는 document 조회
db.employees.find(
    {
        status: { $exists: true }
    }
)

//27.status column이 존재하지 않는 document 조회
db.employees.find(
    {
        status : { $exists: false }
    }
)

//28.hire_date column이 존재하는 document 조회
db.employees.find(
    {
        hire_date: { $exists: true }
    }
)

//29.hire_date column이 존재하지 않는 document 조회
db.employees.find(
    {
        hire_date: { $exists: false }
    }
)

//30.status column이 존재하는 document count 조회
db.employees.count(
    {
        status: { $exists: true }
    }
)

//31.hire_date column이 존재하는 document count 조회
db.employees.count(
    {
        hire_date: { $exists: true }
    }
)

//32.select distinct(department) from employees
db.employees.distinct(
    "department"
)

//33.select * from employees where salary >= 50000
db.employees.find(
    {
        salary: { $gte: 50000 }
    }
)

//34.select * from emploees where salary < 50000
db.employees.find(
    {
        salary: { $lt: 50000 }
    }
)

//35.select * from employees where salary > 45000 and salary <= 60000
db.employees.find(
    {
        salary: {$gt: 45000, $lte: 60000}
    }
)

//36.update employees set salary = 57000 where number = 1005
db.employees.updateMany(
    {
        number: 1005
    },
    {
        $set: { salary: 57000 }
    }
)

//37.update employees set last_name = '홍' where number = 1005
db.employees.updateMany(
    {
        number: 1005
    },
    {
        $set: { last_name: '홍' }
    }
)

//38.update employees set salary = salary + 100 where number in (1005,1006)
db.employees.updateMany(
    {
        number: { $in: [1005, 1006] }
    },
    {
        $inc: {salary: 100}
    }
)

//39.delete from employees where status = 'A'
db.employees.deleteMany(
    {
        status: 'A'
    }
)

//update() operation uses the $unset operator to remove the fields status and salary
//number가 1006 인 document의 status , salary  필드값 제거하기
db.employees.updateOne(
    {
        number: 1006
    },
    {
        $unset: { status: 1, salary: 1 }
    }
)

db.employees.find()

// sample_mflix의 movie에서 genre별로 group by

use sample_mflix

db.movies.distinct(
    'genres'
)

// 장르별 코멘트의 합
db.movies.aggregate([
    // 영어로 된 영화 필터링
    { $match: {languages: 'English'} },
    // 장르별 코멘트 합계
    { $group: { _id: '$genres', sumComment: { $sum: '$num_mflix_comments' }}  }
])

// 장르별 코멘트의 합 -> sorting, top 5