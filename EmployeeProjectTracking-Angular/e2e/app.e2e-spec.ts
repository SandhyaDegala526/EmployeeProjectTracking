import { EmpProjectTrackingPage } from './app.po';

describe('emp-project-tracking App', function() {
  let page: EmpProjectTrackingPage;

  beforeEach(() => {
    page = new EmpProjectTrackingPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
