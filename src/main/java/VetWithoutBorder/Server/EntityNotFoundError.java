package VetWithoutBorder.Server;

import lombok.Data;

@Data
class QueryError {
    private String error;

    QueryError(String error) {
        this.error = error;
    }
}

class EntityNotFoundError extends RuntimeException {

    EntityNotFoundError(String entityName){
        super(entityName + " is not found");
    }

    QueryError errorMessage() {
        return new QueryError(this.getMessage());
    }
}
