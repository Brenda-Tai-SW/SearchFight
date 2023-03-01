Requirement : Searchfight

In order to determine the popularity of people on the web, we need to 
implement  a program that can trigger people in different search engines and return
the amount of hits found.

Example:
$ java searchfight .net java
.net: Google: 4450000000 MSN Search: 12354420
java: Google: 966000000 MSN Search: 94381485
Google winner: .net
MSN Search winner: java
Total winner: .net
Rules:
? Our program should be able to receive a variable number of search terms.
? Our program must support quotation marks so you can specify search terms
containing spaces (java searchfight "bill gates" "larry ellison")
? our program must support at least two different search engines.
