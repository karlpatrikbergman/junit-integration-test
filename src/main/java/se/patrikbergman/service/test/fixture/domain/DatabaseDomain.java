package se.patrikbergman.service.test.fixture.domain;

public enum DatabaseDomain {
	ACCOUNT("account"),
	TRANSACTIONS("transactions");

	private final String name;

	DatabaseDomain(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static DatabaseDomain fromValue(String value) throws IllegalArgumentException {
		for(DatabaseDomain databaseDomain : DatabaseDomain.values()) {
			if(databaseDomain.getName().equals(value)) {
				return databaseDomain;
			}
		}
		throw new IllegalArgumentException("Unknown value. Failed to create enum Domain");
	}
}
