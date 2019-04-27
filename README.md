# Specialisation Overview

This repo contains the assignments' problem statements and my solutions.

An overview of the topics covered in each course is given below.

## Course 1: Functional Programming Principles in Scala

* Getting Started + Functions & Evaluation
  * difference between functional imperative programming
  * basics of Scala; expressions, evaluation, conditionals, functions, and recursion
* Higher Order Functions
  * functions as first-class values
  * higher order functions
  * methods, classes, and data abstraction
* Data and Abstraction
  * traits
  * how to organize classes into hierarchies
  * hierarchy of standard Scala types
  * how to organize classes and traits into packages
  * different kinds of polymorphism in Scala
* Types and Pattern Matching
  * relationship between functions and objects in Scala
  * Scala's type system - including subtyping and generics, and variance
  * Lists
  * pattern matching.
* Lists
  * more functions on Lists
  * Tuples
  * implicit parameters
* Collections
  * vectors, maps, ranges, arrays, and more 
  * for-comprehensions for querying data
  
[Certification link](https://www.coursera.org/account/accomplishments/certificate/KF2MJFUHW2RT) (Grade: 100%)

## Course 2: Functional Program Design in Scala

* For Expressions and Monads
  * queries with for-comprehensions 
  * how the for-comprehension is "desugared" by the Scala compiler
  * monads and how to verify that the monad laws are satisfied
* Lazy Evaluation
  * performance issues caused by combinatorial search 
  * laziness
  * proofs on trees; extending structural induction to trees
* Functions and State
  * state and side-effects
  * programming patterns for managing state in larger programs
  * for-loops and while-loops in Scala
* Timely Effects
  * the observer pattern
  * functional reactive programming
  * how latency can be modeled as an effect
  * how latency can be handled with Scala's monadic futures
  * important combinators on futures
  * how futures can be composed to build up rich and responsive services
  
[Certification link](https://www.coursera.org/account/accomplishments/certificate/ULRCKMUTDY4S) (Grade: 100%)
  
## Course 3: Parallel Programming

* Parallel Programming
  * basic constructs for building parallel programs on JVM and Scala
  * array norm and Monte Carlo examples
  * how to estimate work and depth of parallel programs
  * how to benchmark parallel implementations
* Basic Task Parallel Algorithms
  * parallel merge sort example
  * how operations such as map, reduce, and scan can be computed in parallel
  * associativity as the key condition enabling parallel implementation of reduce and scan
* Data-Parallelism
  * how data parallel operations enable the development of elegant data-parallel code in Scala
  * overview of the parallel collections hierarchy
  * splitters and combiners, with comparison to iterators and builders
* Data Structures for Parallel Computing
  * internals of data structures for parallel computing
  * what happens under the hood of parallel collections

[Certification link](https://www.coursera.org/account/accomplishments/certificate/ZLYY5CUCDP3T) (Grade: 100%)

## Course 4: Big Data Analysis with Scala and Spark

* Getting Started + Spark Basics
  * bridging the gap between data parallelism in the shared memory scenario and the distributed scenario 
  * important concerns in distributed systems, like latency and failure
  * basics of Spark 
  * hands on real-world data set analysis
* Reduction Operations & Distributed Key-Value Pairs
  * pair RDDs
  * essential operations on large data sets, such as reductions and joins, with pair RDDs
* Partitioning and Shuffling
  * performance implications of using operations like joins 
  * partitioning data to achieve better data locality, and in turn optimizing some Spark jobs
* Structured data: SQL, Dataframes, and Datasets
  * Spark SQL
  * using structure to apply impressive optimizations
  * DataFrames and Datasets - mixing RDDs with the powerful automatic optimizations behind Spark SQL.

[Certification link](https://www.coursera.org/account/accomplishments/certificate/7AQ8X3CPWHU7) (Grade: 100%)
