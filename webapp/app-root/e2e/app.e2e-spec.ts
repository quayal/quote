import { AppRootPage } from './app.po';

describe('app-root App', () => {
  let page: AppRootPage;

  beforeEach(() => {
    page = new AppRootPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
