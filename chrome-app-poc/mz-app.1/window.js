$ = function(selector) { return document.querySelector(selector); }

$('#fullscreen').onclick = function(e) {
  setTimeout(chrome.app.window.current().fullscreen, 3);
};