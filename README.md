# Customer Management Training

Small trainer demo project for showing a practical IntelliJ IDEA and Git workflow.

## Today's Requirement

Use this ticket during the demo:

```text
CMT-104: Add phone number to the customer response
```

The project is intentionally small. The goal is to teach the workflow, not advanced Spring Boot.

## Demo Flow

1. Open the project in IntelliJ IDEA.
2. Explain the project structure.
3. Pull the latest code from the base branch.
4. Create a feature branch:

```text
feature/CMT-104-add-customer-phone
```

5. Update the customer response to include `phoneNumber`.
6. Update sample customer data.
7. Run the tests.
8. Review the diff.
9. Commit:

```text
CMT-104 Add phone number to customer response
```

10. Push the branch and explain the pull request step.

## Useful Commands

Run tests:

```bash
mvn test
```

Start the app:

```bash
mvn spring-boot:run
```

Try the API:

```bash
curl http://localhost:8080/customers/1
```

## Project Structure

```text
src/main/java/com/trainerdemo/customer
├── CustomerManagementTrainingApplication.java
├── controller
├── dto
├── model
├── repository
└── service
```

## Homework Ticket

```text
CMT-105: Add active status to the customer response
```

Suggested branch:

```text
feature/CMT-105-add-customer-status
```

Suggested commit message:

```text
CMT-105 Add active status to customer response
```
