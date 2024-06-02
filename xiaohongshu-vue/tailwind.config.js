/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
    "./node_modules/flowbite/**/*.js"
  ],
  theme: {
    colors: {
      mainred: '#ff2e4d'
    },
    extend: {},
  },
  plugins: [
    require('flowbite/plugin')
  ],
}

