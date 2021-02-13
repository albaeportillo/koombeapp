# koombeapp
Test for koombea


Mobile Technical Skills Test
This document will serve as the primary reference for the Technical Skills Test. The
Technical skill test is designed to identify suitable candidates for technical roles.
Moreover, this document includes API documentation, design guides and
downloads, methods, responses, and parameters the developer will use to perform
the test.
Technical Test Development
The developer will be asked to develop a mobile application using the latest native
programming language to develop an application using the documentation
provided herein.
The developer shall provide the source code of the application for further analysis
and testing, a Git repository would be ideal.
Brief
Rules
○ Use the latest coding best practices
○ Persist data locally for offline use
○ Provide source code
○ Use the 3rd party libraries
You will be qualified By
○ Attention to details
○ Completeness and User interface
○ Code quality
○ Software Design Patterns and Software Architectural Pattern
Questions/Problems? Please feel free to contact us at any time:
mario@koombea.com
carlos.lopez@koombea.com
Technical Requirements
1. Build the native app using the latest version of Android and Retrofit
2. Must use CouchBase lite . We’ll evaluate your skills to use new services and
libraries and how with only documentation you can get it working.
Workflow
1. Connect to the API to fetch all models
2. Store local models for offline mode
3. Show data
4. Make use of a Pull Down to Refresh feature to reload the home screen
Requirements
● I should see the user information per post:
○ Should display a circle profile picture
○ Should display user name, email, and date.
○ The date should use an ordinal format, e.g Dec 21st.
● Post format:
○ One Image, 1 box, 1 big image
○ Two Images, 1 box with 2 medium images
○ Three Images, 2 boxes, 1 big image, and 2 medium images
○ Four or more Images, 2 boxes, 1 big image, 1 horizontal scrolling
collection with all the rest of the images, small images
○ All images should be a perfect square fit, respect margins
● When tapping on an image, I should see the image popup view.
○ The background should use a blur effect
○ I should swipe-down to dismiss the popup
● Should cache the images locally in the device, after the first time use, I can
open the app and view images without a network connection
● Pull down to refresh should flush the cache and fetch new data
Bonus (Optional)
● Unit Testing, add at least 3 unit testing cases using XCTests
● Skeleton loading
● No internet validation
API Documentation
Endpoint URL : https://mock.koombea.io/mt/api/posts
API response and sample results
Request URI: https://mock.koombea.io/mt/api/posts
Method: GET
Returns: An array of Users and posts
Visual and Design Guidelines
We care about clean design, simple yet elegant user-experience.
Use the following design guides for your test.
Best of luck and happy coding!!
Koombea.
