package ru.bryzgalin.dbDAO.exceptions;

public class FieldSetException extends DaoException {
  public FieldSetException(String message) {
    super(message);
  }

  public FieldSetException(String message, Throwable cause) {
    super(message, cause);
  }
}