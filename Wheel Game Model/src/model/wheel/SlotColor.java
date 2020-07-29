package model.wheel;

public enum SlotColor {

	BLACK {

		// Override toString method

		@Override
		public String toString() {
			return "Black";
		}
	},

	RED {

		// Override toString method

		@Override
		public String toString() {
			return "Red";
		}
	},

	GREEN0 {

		// Override toString method

		@Override
		public String toString() {
			return "Green Zero";
		}
	},

	GREEN00 {

		// Override toString method

		@Override
		public String toString() {
			return "Double Zero";
		}
	};

}
