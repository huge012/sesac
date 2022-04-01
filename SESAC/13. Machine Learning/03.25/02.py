# -*- coding: utf-8 -*-
"""02.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1Vmdzh1WwHmvN61I9QV-AGw5VFevsxRsL
"""

# Commented out IPython magic to ensure Python compatibility.
# %run my_init.py

# Commented out IPython magic to ensure Python compatibility.
# %matplotlib inline

from sklearn.ensemble import VotingClassifier, BaggingClassifier, RandomForestClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.datasets import load_breast_cancer

obj = load_breast_cancer()
obj

print(f"▶ feature_name {obj.feature_names.shape}\n{obj.feature_names}", end="\n\n")
print(f"▶ data {obj.data.shape}\n{obj.data}", end="\n\n")
print('--------------------------------------------------------')
print(f"▶ target_names {obj.target_names.shape}\n{obj.target_names}", end="\n\n")
print(f"▶ target {obj.target.shape}\n{obj.target}", end="\n\n")

X, y = load_breast_cancer(return_X_y=True)
print(f"X {X.shape}\n{X}", end='\n\n')
print(f"y {y.shape}\n{y}", end='\n\n')

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
X_train.shape, y_train.shape, X_test.shape, y_test.shape

lr = LogisticRegression() # 데이터 표준화 중요
knn = KNeighborsClassifier() # 데이터 표준화 중요
dt = DecisionTreeClassifier()
rf = RandomForestClassifier()  # 배깅 기반, 이진트리로 고정
vt = VotingClassifier([('LR', lr), ('KNN', knn)]) # 보팅 - 여러 모델
bg = BaggingClassifier(dt, 100) # 배깅 - 하나의 모델

for clf in [lr, knn, vt, dt, bg, rf]:
  clf.fit(X_train, y_train)
  y_pred = clf.predict(X_test)
  print(f"{clf.__class__.__name__}: {accuracy_score(y_test, y_pred):4f}")

"""랜덤 포레스트훈련"""

from sklearn.model_selection import cross_validate
from sklearn.ensemble import RandomForestClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import cross_validate

wine = pd.read_csv("https://bit.ly/wine_csv_data")
wine.head(3)

data = wine.drop('class', axis=1).to_numpy()
data.shape

target = wine['class'].to_numpy()
target.shape

train_input, test_input, train_target, test_target = train_test_split(data, target, test_size=0.2, random_state=42)

train_input.shape, train_target.shape

test_input.shape, test_target.shape

dt = DecisionTreeClassifier(random_state=42)

scores = cross_validate(dt, train_input, train_target, cv=3, return_train_score=True)
scores

rf = RandomForestClassifier(n_jobs = 1, random_state=42)

# CV 5개가 default
scores = cross_validate(rf, train_input, train_target, n_jobs=-1, return_train_score=True)

scores['train_score']

scores['test_score'] # validation score

np.mean(scores['test_score'])

rf.fit(train_input, train_target)

rf.feature_importances_

rf.predict(test_input)

rf.predict_proba(test_input)

accuracy_score(test_target, rf.predict(test_input))

rf = RandomForestClassifier(oob_score=True, n_jobs=-1, random_state=42)
rf.fit(train_input, train_target)

rf.oob_score_