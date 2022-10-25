package model;

public enum StatusCargo {
	
	ASSISTENTE {
		@Override
		public StatusCargo getProximoCargo() {
			return ANALISTA;
		}
	},
	ANALISTA {
		@Override
		public StatusCargo getProximoCargo() {
			return ESPECIALISTA;
		}
	},
	ESPECIALISTA {
		@Override
		public StatusCargo getProximoCargo() {
			return GERENTE;
		}
	},
	GERENTE {
		@Override
		public StatusCargo getProximoCargo() {
			return GERENTE;
		}
	};

	public abstract StatusCargo getProximoCargo();
	
	

}
