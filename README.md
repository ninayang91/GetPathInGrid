# GetPathInGrid
From (0,0) to (x,y) in a grid, find a path

Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can only move in two directions: right and down. How many possible paths are there for the robot to go from (0,0) to (X,Y)?

(x+y) choose x grids=((x+y)!)/(x!*y!)

FOLLOW UP:
Imagine certain spots are "off limits," such that the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to the bottom right.

Recursion: 
boolean getPath(x,y,path) if (x==0 && y==0), then try left, if not success try up, if success, add p to path, return success

Dynamci programming:
HashTable<K,V>  HashTable<Point,boolean> cache

if(cache.containsKey()p) return cache.get(p)

if success, cache.put(p,success)

