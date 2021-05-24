package com.project1.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.simpleDateFormat;

import com.project1.model.Reimbursement;


	
	public class ReimbursementDao {
		DatabaseConnection dbconnection = new DatabaseConnection(); // object name dbconnection created for DatabaseConnection class

		//@SuppressWarnings("deprecation")
		public static void main(String[] args) {
			
			ReimbursementDao reim = new ReimbursementDao(); // Making an instance of the ReimbusresementDao Class
			System.out.println(reim.getAllReimbursement()); // print getAllReimbursement
			
			//ReimbursementDao reimb = new ReimbursementDao();
			//reimb = .getReimbursementById(1);
			//System.out.println(reimb.getReimbursementById());
			
			
			 Reimbursement reimb = new Reimbursement(); 
			 reimb = reim.getReimbursementById(1); 
			 System.out.println(reimb);
			  

			 List<Reimbursement> reimb_list = new ArrayList<Reimbursement>();
			 reimb_list = reim.getReimbursementByAuthorId(1); 
			 System.out.println(reimb_list);
			 
			 reim.updateReimbursement(2, 1);
			 
			 //Date date = new Date();
			 long now = System.currentTimeMillis();
			 Timestamp sqltimestamp =new Timestamp(now);
			 reim.createNewReimbursement(400.12, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 
					 "FOOD was great",(byte) 0, 1,1,1,3);
			 
			 //Date date = new Date();
			 //System.out.println(new Timestamp(date.getTime()));
			 //System.out.println(Timestamp.getTime());
			  
			 
			
		}
		
	
		public List<Reimbursement> getAllReimbursement() {
			List<Reimbursement> ReimbursementList = new ArrayList<Reimbursement>(); // since we cannot access the method directly we created a variable name of the object
			try(Connection conn = dbconnection.getDbConnection()){
				String sql = "select * from ersdb.ers.\"ers_reimbursement\"";
				PreparedStatement ps = conn.prepareStatement (sql); //PreparedStatement is a default class
				ResultSet rs = ps.executeQuery(); // executing query of PreparedStatement 
				
				while(rs.next()) {
					Reimbursement reim = new Reimbursement();  //creating object
					reim.setReimbursementDescription(rs.getString("reimb_description")); // accessing the method setUsername by using user obj, 
													//then accessing the "username" column of the current row
					reim.setReimbursementResolved(rs.getTimestamp("reimb_resolved"));
					reim.setReimbursementStatusId(rs.getInt("reimb_status_id"));
					reim.setReimbursementTypeId(rs.getInt("reimb_type_id"));
					reim.setAmount(rs.getDouble("reimb_amount"));
					reim.setReceipt(rs.getByte("reimb_receipt"));
					reim.setAuthorID(rs.getInt("reimb_author"));
					reim.setResolverId(rs.getInt("reimb_resolver"));
					ReimbursementList.add(reim); // every row gets added to the REimbursementList
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return ReimbursementList; // returning the variable of List of User (List<User>)
		}

	
		public Object getOne(Serializable id) {
							
			return null;
		}

		
	
		public Reimbursement getReimbursementById(Integer id) {
			Reimbursement reimb = null;			
			try(Connection conn = dbconnection.getDbConnection()){
				String sql = "select * from ersdb.ers.\"ers_reimbursement\" where reimb_id = ?";
				PreparedStatement ps = conn.prepareStatement (sql); //PreparedStatement is a default class
				ps.setInt(1,  id);
				ResultSet rs = ps.executeQuery(); // executing query of PreparedStatement 
				
				while(rs.next()) {

					reimb = new Reimbursement();
					reimb.setAmount(rs.getInt("reimb_amount"));					
					reimb.setReimbusermentSubmitted(rs.getTimestamp("reimb_submitted"));
					reimb.setReimbursementResolved(rs.getTimestamp("reimb_resolved"));
					reimb.setReimbursementDescription(rs.getString("reimb_description"));
					reimb.setReceipt(rs.getByte("reimb_receipt"));
					reimb.setAuthorID(rs.getInt("reimb_author"));
					reimb.setResolverId(rs.getInt("reimb_resolver"));
					reimb.setReimbursementStatusId(rs.getInt("reimb_status_id"));
					reimb.setReimbursementTypeId(rs.getInt("reimb_type_id"));

				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
			return reimb;
		}
		
		public List<Reimbursement> getReimbursementByAuthorId(Integer id) {
			List<Reimbursement> reimbs = new ArrayList<Reimbursement>(); // since we cannot access the method directly we created a variable name of the object
			try(Connection conn = dbconnection.getDbConnection()){
				String sql = "select * from ersdb.ers.\"ers_reimbursement\" where reimb_author = ?";
				PreparedStatement ps = conn.prepareStatement (sql); //PreparedStatement is a default class
				ps.setInt(1,  id);
				ResultSet rs = ps.executeQuery(); // executing query of PreparedStatement
				
				while(rs.next()) {

					Reimbursement re = new Reimbursement();
					re.setReimbursmentID(rs.getInt("reimb_id"));
					re.setAmount(rs.getInt("reimb_amount"));
					re.setReimbusermentSubmitted(rs.getTimestamp("reimb_submitted"));
					re.setReimbursementResolved(rs.getTimestamp("reimb_resolved"));
					re.setReimbursementDescription(rs.getString("reimb_description"));
					re.setReceipt(rs.getByte("reimb_receipt"));
					re.setAuthorID(rs.getInt("reimb_author"));
					re.setResolverId(rs.getInt("reimb_resolver"));
					re.setReimbursementStatusId(rs.getInt("reimb_status_id"));
					re.setReimbursementTypeId(rs.getInt("reimb_type_id"));
					reimbs.add(re);

				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}
			
			return reimbs;
				
			}
		
		public void createNewReimbursement(double reimb_amount, 
				Timestamp reimb_submitted, Timestamp reimb_resolved,
				String reimb_description, byte reimb_receipt,
				Integer reimb_author, Integer reimb_resolver, 
				Integer reimb_status_id, Integer reimb_type_id){
			
			try(Connection conn = dbconnection.getDbConnection()){
				/*String sql = "insert into ersdb.ers.ers_reimbursement (reimb_amount, "
						+ "reimb_submitted, "
						+ "reimb_resolved, "
						+ "reimb_description, "
						+ "reimb_receipt, "
						+ "reimb_author, "
						+ "reimb_resolver, "
						+ "reimb_status_id, "
						+ "reimb_type_id) "
						+ "values (" + reimb_amount + ", " + reimb_submitted + ", " + reimb_resolved + ", " + reimb_description + ", " 
						+ reimb_receipt + ", " + reimb_author + ", " + reimb_resolver + ", " + reimb_status_id + ", " + reimb_type_id + ")";
					*/
				
				String sql = "insert into ersdb.ers.ers_reimbursement (reimb_amount, "
						+ "reimb_submitted, "
						+ "reimb_resolved, "
						+ "reimb_description, "
						+ "reimb_receipt, "
						+ "reimb_author, "
						+ "reimb_resolver, "
						+ "reimb_status_id, "
						+ "reimb_type_id) "
						+ "values (400.12, 2021-04-26 12:59:35.666, 2021-04-26 12:59:35.666, FOOD was great, 0, 1, 1, 1, 3)";
				
				System.out.println(sql);
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.executeQuery();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			
			/*insert into ers_reimbursement (reimb_amount, 
					reimb_submitted, 
					reimb_resolved ,
					reimb_description, 
					reimb_receipt, 
					reimb_author, 
					reimb_resolver, 
					reimb_status_id, 
					reimb_type_id) values (212.12, CURRENT_TIMESTAMP, null, 'FOOD was great',null, 1,1,1,3);*/
			
		}


		public void updateReimbursement(Integer statusid, Integer reimbid) {
			
			try(Connection conn = dbconnection.getDbConnection()){
				String sql = "update ersdb.ers.\"ers_reimbursement\" set \"reimb_status_id\" =" + statusid + " where \"reimb_id\" = " + reimbid;
				//log.trace("inside update, before prepared statement");
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			
				//log.trace("update executed");
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}			
			
		}
			
		


		public Serializable logIn(Serializable username, Serializable password) {
			// TODO Auto-generated method stub
			return null;
		}

		

	
}
