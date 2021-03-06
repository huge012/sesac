# -*- coding: utf-8 -*-
"""d06_02.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/16xBq59aoeXMGzguY5KF1ckHyhwZVWdLp
"""

# Commented out IPython magic to ensure Python compatibility.
# %run my_init.py

# Commented out IPython magic to ensure Python compatibility.
# %matplotlib inline

fish = pd.read_csv('https://bit.ly/fish_csv_data')
fish.head()

fish.columns

fish_input = fish[['Weight', 'Length', 'Diagonal', 'Height', 'Width']].to_numpy()

# fish_input = fish.drop('Species', axis=1).to_numpy()

np.sort(pd.unique(fish['Species']))

fish_target = fish['Species'].to_numpy()
fish_target

train_input, test_input, train_target, test_target = train_test_split(fish_input, fish_target, random_state=42)

train_input.shape, train_target.shape

test_input.shape, test_target.shape

from sklearn.preprocessing import StandardScaler

ss = StandardScaler()
train_scaled = ss.fit_transform(train_input)
test_scaled = ss.transform(test_input)

from sklearn.neighbors import KNeighborsClassifier

kn = KNeighborsClassifier(n_neighbors=3)
kn.fit(train_scaled, train_target)

kn.classes_

test_scaled[:5]

kn.predict(test_scaled[:5])

kn.predict_proba(test_scaled[:5])

kn.predict(test_scaled[3:4])

kn.predict_proba(test_scaled[3:4])

index = kn.kneighbors(test_scaled[3:4], return_distance=False)
index

train_target[index]

