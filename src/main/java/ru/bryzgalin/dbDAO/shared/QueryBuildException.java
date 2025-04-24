package ru.bryzgalin.dbDAO.shared;

public class QueryBuildException extends DaoException {
    public QueryBuildException(String message) {
        super(message);
    }

    public QueryBuildException(String message, Throwable cause) {
        super(message, cause);
    }
}
