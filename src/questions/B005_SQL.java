package questions;

 
public class B005_SQL {

	
	/**

			SQL: Given 2 tables, Student and Scoring, a student may have multiple scores, 
			find the id, sum(score) list that the sum of student’s score > 10.
			
			Student Table:                                 
			
			id            name                   
			
			1             a                           
			
			2             b                           
			
			3             c                                          
			
			4             d                           
			
			Scoring Table:
			
			name           score
			
			a                   3
			
			a                   5
			
			a                   1
			
			d                   5
			
			d                   6
			
			b                   4
			
			b                   11
			
			d                   null
			
			
			The result should be
			
			id            sum_score
			
			4             11
			
			2             15
			
			select stu.id, sum(score) sum_score
			from Student
			inner join Scoring sc on stu.name = sc.name
			where sc.score is not null
			group by stu.id 
			having sum(score) > 10
		
	 */
 
}
