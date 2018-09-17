package questions;

 
public class B004_SQL {

	
	/**
	 * SQL: Given 2 tables, User and Scoring, find the id list whose score > 10.

		User Table:                                       Scoring Table:
		
		id            username                  username            		score
		
		1             a                            a                            13
		
		2             b                            d                            5
		
		3             c                            b                            41
		
		4             d                            c                            10
		
		The result should be
		
		id            score
		
		1             13
		
		3             41
		
		Select u.id, s.score
		from user u
		inner join scoring s on u.username = s.username
		where s.score > 10 
		
	 */
 
}
