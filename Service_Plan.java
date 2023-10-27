package Enumm_Package;

	public enum Service_Plan {
		SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000),NONE(0);
		
		private int plan;
		private double price;

		Service_Plan(int plan) {
			this.plan=plan;
		}

		public int getPlan() {
			return plan;
		}
		
		private Service_Plan(double price) {
			this.price=price;
		}

		public double getPrice() {
			return price;
		}

//		@Override
//		public String toString() {
//			return name().toUpperCase()+"The price is"+price;
//		}

		
		@Override
		public String toString() {
			return name().toUpperCase()+"The price is : "+price;
		}
		
		

	}


