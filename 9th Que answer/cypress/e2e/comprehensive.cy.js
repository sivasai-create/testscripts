describe('My Test Suite', () => {
  let testData;
 
  before(() => {
     cy.visit('https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/')
     cy.fixture('testData.json').then((data) => {
       testData = data;
     })
  })
 
  it('should verify the page title', () => {
     cy.title().should('include', testData.expectedTitle)
  })
 
  it('should click on Speaking and verify the title of the page', () => {
     cy.visit('https://automationpanda.com/speaking/')
     cy.title().should('include', testData.expectedPageTitle)
   })

     it('should verify if Keynote Addresses" is present and check the text', () => {

     cy.get('.wp-block-heading', { timeout: 10000 }).should('be.visible')
     cy.contains('Keynote Addresses').invoke('text').should('include', testData.expectedText)
  })
})



 