One recurring problem that I observe is the application of ad hoc solutions instead of applying the intended algorithms, which in this context is fatal.
* Your calendar implementation does not use divide and conquer, but an iterative approach.
* NullPath does not implement backtracking. It uses random selection instead of a sistematic exploration. There is no semblance of backtracking when a path fails. It doesn't make sense, really.

Other issues:
* No delivery at Greedy algorithms.
* Floyd is all wrong. The main issue is in the floyd() method. The implementation incorrectly updates the original weights matrix instead of filling the costs matrix. The p matrix is being incorrectly initialized with weights instead of predecessors. The algorithm doesn't properly initialize the costs and predecessors matrices. The minimumPath() and path() methods don't align with how the matrices are being populated...

Minimum of 5 in the lab sessions won't be reached.
