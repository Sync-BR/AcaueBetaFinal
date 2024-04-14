import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'


const port = 5179;

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    port: port
  }

})
