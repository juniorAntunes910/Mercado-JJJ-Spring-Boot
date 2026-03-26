/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/Front/**/*.{html,js}", // Aqui é onde está sua bagunça atual
    "./src/main/resources/templates/**/*.html", // Onde o Spring costuma guardar HTML
    "./src/main/resources/static/**/*.js" // Onde o Spring guarda JS
  ],
  theme: {
    extend: {},
  },
  plugins: [require("daisyui")],
}