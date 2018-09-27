package com.global.employee.enums;

public enum TypeOfContract {
	HOURLY("HourlySalaryEmployee"), MONTHLY("MonthlySalaryEmployee"), NON_EXISTENT("");

	private String typeOfContract;

	private TypeOfContract(String typeOfContract) {
		this.typeOfContract = typeOfContract;
	}

	public String getContract() {
		return typeOfContract;
	}

	public static TypeOfContract fromString(String value) {
		for (TypeOfContract contract : TypeOfContract.values()) {
			if (contract.typeOfContract.equalsIgnoreCase(value)) {
				return contract;
			}
		}
		return NON_EXISTENT;
	}

}
