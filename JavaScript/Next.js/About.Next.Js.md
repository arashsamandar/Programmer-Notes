## types of data fetching in Next.js

> 1. Static Generation : `getStaticProps` static ( build time ) data fetching, ideal for static contents like a gallary or blog
>
> 2. Server-side Rendering : `getServerSideProps` runs on every request, fetching the latest data and rendering the page server-side. This ensures that users always see the most current information.
>
> 3. Incremental Static Regeneration (ISR) : combination of both
>
> 4. Client-side Data Fetching Use Case : Suitable for data that changes in real-time or is user-specific.How It Works: Data is fetched on the client side, typically using React hooks like `useEffect` and state management. This method is useful for user-specific data or real-time data that doesn't need to be pre-rendered. Example : Useful for user profiles, real-time notifications, or any data that is specific to the user's session.
>
>    

- **CSR (Client-Side Rendering)**: Data is fetched and the page is rendered in the browser after the initial page load. This approach is suitable for highly interactive applications where the content changes frequently or is user-specific.

- **SSG (Static Site Generation)**: Data is fetched at build time, and the page is pre-rendered as static HTML. This method is ideal for content that doesn't change often, as it provides fast load times and SEO benefits without the need for server-side processing on each request.