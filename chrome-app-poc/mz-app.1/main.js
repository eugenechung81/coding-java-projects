/**
 * Listens for the app launching then creates the window
 *
 * @see http://developer.chrome.com/apps/app.runtime.html
 * @see http://developer.chrome.com/apps/app.window.html
 */
chrome.app.runtime.onLaunched.addListener(function() {
  runApp();
  //chrome.app.window.current().fullscreen
});

/**
 * Listens for the app restarting then re-creates the window.
 *
 * @see http://developer.chrome.com/apps/app.runtime.html
 */
chrome.app.runtime.onRestarted.addListener(function() {
  runApp();
});


/**
 * Creates the window for the application.
 *
 * @see http://developer.chrome.com/apps/app.window.html
 */
function runApp() {
  chrome.app.window.create('browser.html', {
  	id: "browserWinID",
    bounds: {
      'width': 1024,
      'height': 768
    }
  });
  //setTimeout(chrome.app.window.fullscreen, 2);
  //chrome.app.window.current().fullscreen;
}


/*
chrome.commands.onCommand.addListener(function(command) {
  console.log('onCommand event received for message: ', command);
});
*/

