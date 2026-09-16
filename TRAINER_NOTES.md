# Trainer Notes

## Session Goal

By the end of the session, the trainee should understand the everyday developer flow:

```text
Jira ticket -> IntelliJ project -> Git branch -> code change -> test -> diff review -> commit -> push -> pull request
```

## Opening Script

Hi Shravani! Today we will connect yesterday's Jira discussion with actual development work.

Yesterday we saw how a developer receives and understands a ticket. Today we will look at what happens after you move a ticket to In Progress. We open the project in IntelliJ, create a Git branch, make a small code change, test it, review the diff, commit it, and push it.

The goal today is not to learn every IntelliJ menu or every Git command. The goal is to understand the safe everyday workflow.

## Ticket For Today

```text
CMT-104: Add phone number to the customer response
```

Acceptance criteria:

- `GET /customers/{id}` should still return customer details.
- The response should include `phoneNumber`.
- Existing tests should pass.
- The change should be committed on a feature branch.

## What To Show In IntelliJ

- Project window
- `src/main/java`
- `src/test/java`
- `pom.xml`
- Main application class
- Controller
- Service
- Repository
- DTO
- Test class
- Git branch selector
- Commit window
- Diff viewer
- Terminal

## Suggested Teaching Questions

- Which ticket are we working on?
- Which branch should contain this change?
- Which class controls the API response?
- What should we run before committing?
- What is the difference between commit and push?
- Does pushing automatically merge the code?

## Files To Change For CMT-104

Guide the trainee to discover these files instead of naming them immediately:

- `CustomerResponse.java`
- `Customer.java`
- `InMemoryCustomerRepository.java`
- `CustomerServiceTest.java`

## Closing Reminder

The one flow to remember today:

```text
Pull base branch -> create feature branch -> change -> test -> review diff -> commit -> push -> PR
```
