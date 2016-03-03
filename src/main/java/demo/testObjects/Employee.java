package demo.testObjects;


public class Employee{
	
		private String empId;
		private String empName;

		/**
		 * @return the empId
		 */
		public String getEmpId() {
			return empId;
		}

		/**
		 * @param empId the empId to set
		 */
		public void setEmpId(String empId) {
			this.empId = empId;
		}

		/**
		 * @return the empName
		 */
		public String getEmpName() {
			return empName;
		}

		/**
		 * @param empName the empName to set
		 */
		public void setEmpName(String empName) {
			this.empName = empName;
		}

		
		public Employee(String EmpId, String EmpName){
			this.empName = EmpName;
			this.empId = EmpId;
		}
		
}
