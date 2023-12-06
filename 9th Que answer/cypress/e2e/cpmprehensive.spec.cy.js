

describe('My Test Suite', () => {
    before(() => {
      cy.visit('https://automationpanda.com/2021/12/29/want-to-practice-test-automation-try-these-demo-sites/')
    })
  
    it('should verify the page title', () => {
      cy.title().should('include', 'Want to practice test automation? Try these demo sites! | Automation Panda')
    })
  
    it('should click on Speaking and verify the title of the page', () => {
        cy.visit('https://automationpanda.com/speaking/')
        cy.title().should('include', 'Speaking | Automation Panda')

  
    //should verify if "Keynote Addresses" is present and check the text
      
        cy.contains('Keynote Addresses').should('exist');
      
        cy.contains('Keynote Addresses').invoke('text').should('include', 'Keynote Addresses');
      });
      
  })
  