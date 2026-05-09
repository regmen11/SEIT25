Feature: The Internet
  This feature covers (some) Example pages on 'the-internet.herokuapp.com'

  @TEST_TI_0001
  Scenario: Homepage has a list of links to Expected examples
    Given the page under test is 'https://the-internet.herokuapp.com'
    And header title is 'Welcome to the-internet'
    Then the displayed list of Available Examples should match the following:
      | A/B Testing                                  |
      | Add/Remove Elements                          |
      | Basic Auth (user and pass: admin)            |
      | Broken Images                                |
      | Challenging DOM                              |
      | Checkboxes                                   |
      | Context Menu                                 |
      | Digest Authentication (user and pass: admin) |
      | Disappearing Elements                        |
      | Drag and Drop                                |
      | Dropdown                                     |
      | Dynamic Content                              |
      | Dynamic Controls                             |
      | Dynamic Loading                              |
      | Entry Ad                                     |
      | Exit Intent                                  |
      | File Download                                |
      | File Upload                                  |
      | Floating Menu                                |
      | Forgot Password                              |
      | Form Authentication                          |
      | Frames                                       |
      | Geolocation                                  |
      | Horizontal Slider                            |
      | Hovers                                       |
      | Infinite Scroll                              |
      | Inputs                                       |
      | JQuery UI Menus                              |
      | JavaScript Alerts                            |
      | JavaScript onload event error                |
      | Key Presses                                  |
      | Large & Deep DOM                             |
      | Multiple Windows                             |
      | Nested Frames                                |
      | Notification Messages                        |
      | Redirect Link                                |
      | Secure File Download                         |
      | Shadow DOM                                   |
      | Shifting Content                             |
      | Slow Resources                               |
      | Sortable Data Tables                         |
      | Status Codes                                 |
      | Typos                                        |
      | WYSIWYG Editor                               |


  @TEST_TI_0002
  Scenario: Basic Auth allows validated access
    Given the page under test is 'https://the-internet.herokuapp.com'
    When the "Basic Auth" example link is displayed
    And credentials username "admin" and password "admin" are entered for "basic_auth"
    Then the message "Congratulations! You must have the proper credentials." is displayed


#  @TEST_TI_0001
#  Scenario: Basic Auth allows validated access
#    Given the page under test is 'https://the-internet.herokuapp.com'
#    When the 'Basic Auth' example is opened
#    And valid credentials are supplied
#    Then Congratulations should be displayed
#
#  @TEST_TI_0001
#  Scenario: Sortable Data Tables - Example 1 displays the expected 4 results
#    Given the page under test is 'Sortable Data Tables'
#    And add other steps