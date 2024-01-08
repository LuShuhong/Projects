# Santa's digital transformation

Create a modern web application that allows kids to create lists to santa from a pre-set list of products

## Server

In `/server` you will find a rough API, written with the popular NodeJS framework "ExpressJS"

The following routes are available for use

- GET items
- GET lists
- POST lists
- DELETE lists/:id

This code is **very** rough and requires validations to prevent users from breaking it, see the task list below for guidance. Feel free to make any changes you want to make to any of these files.

Product item images are available at `/img`, use the `image_key` property to line an item up with it's image

An additional route of GET /health allows you to verify your server is working

You may wish to download (https://www.postman.com/)[postman] or (insomnia)[https://insomnia.rest/] to test your API, this is typically useful.

## UI

Please create a suitable UI, there are a few rules

- You should consider using React due to familiarity. Bear in mind that help may be limited for non React apps.
- The UI must use TypeScript and you should try to use it effectively without turning it off
- Feel free to use whatever method of styling you want, be able to explain why
- To make requests to the API, you must use the fetch API

If using `create-react-app` you can use this command

```bash
npx create-react-app ui --template typescript
```

For help connecting your API and avoiding CORS issues, please see this guide https://create-react-app.dev/docs/proxying-api-requests-in-development/

## Requirements

Here's a base list of criteria for your app to meet:

- Lots of kids use tablets, your application should work across a range of devices
- Kids shouldn't be able to break the app by entering bad information
- Kids may create different lists, they should include
  - A date they were created at (format is set to Unix for now but feel free to change)
  - Which kid the list is from
  - A message for santa
  - An indication of how well behaved the kid thinks they have been
  - The names of each item the kid would like to receive
- Kids can see images of all products and a star rating (if available)
- Kids can destroy a list they no longer want
- Kids will want to see a christmas theme (your UI should be very christmassy)

## Stretch activity

- Santa is naturally very busy, perhaps he may wish to assign different lists into statuses such as
  - To process
  - Processed
  - Being made by the elves
- Perhaps a kid might want to add a new item, if something they are looking for doesn't exist?

Your UI should have unit tests and you may also want to research and include end to end tests, perhaps (https://playwright.dev/)[Playwright] would be a good place to start

Beyond this, feel free to add any additional features that you feel will make your app better!
