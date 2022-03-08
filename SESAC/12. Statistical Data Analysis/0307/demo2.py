def fibonacci(n):
  if n<=0:
    return 0
  if n==1 or n==2:
    return 1
  return fibonacci(n-1) +fibonacci(n-2)
#단위 테스트
print("fibonacci(1):", fibonacci(1))
print("fibonacci(2):", fibonacci(2))
print("fibonacci(3):", fibonacci(3))