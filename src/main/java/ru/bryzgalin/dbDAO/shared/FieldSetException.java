package ru.bryzgalin.dbDAO.shared;

public class FieldSetException extends DaoException {
  public FieldSetException(String message) {
    super(message);
  }

  public FieldSetException(String message, Throwable cause) {
    super(message, cause);
  }
}