Commands to work with:
1. Take matrices as input and label them with appropriate matrix-types. >> enter
2. Create matrices of requested matrix-types and label them with appropriate matrix-types. >> create
3. Display all the matrix-type labels of a requested matrix. >> type a
	(here a is the matrix ID)
4. Perform addition, subtraction, multiplication & division. >> a + b or a - b or a * b
	(here a and b are the matrix ID)
5. Perform element-wise operations. >> a.*b and a./b
	(here a and b are the matrix ID)	**The commands are similar to that in MATLAB				
6. Transpose matrices.>> tra a
	(here a is the matrix ID)
7. Inverse matrices.>>inv a
	(here a is the matrix ID)
8. Compute means: row-wise mean, column-wise mean, mean of all the elements. >> mean
										mean r (row wise mean)
										mean c (Column wise mean)
										mean a (mean of all the elements)
9. Compute determinants. >> det a
	(here a is the matrix ID)
10. Compute (A + transpose of A) for a matrix A. >> st a
	(here a is the matrix ID)
11. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.>> show


//to view a particular matrix>> show a
	(here a is the matrix ID)
//to view all matrix>> show A
	(here A is for all and is not a matrix ID.)



There are 15 types of matices, although they are very different they also have similarities
B using OOP The things that are similar can be clubed together, so we do not have to define the same functions for each class.
eg. There are man matrices that are square matrices, they all will be added in the same way,
There is no need to implement them differently for each square matrix.

Making different classes we can also override functions from parent class so we can make the behaviour of the child different
from the parent when we want.

OOP helps in giving a nice structur eto our code, all this in the same file would have become reall ymessy really quickly.