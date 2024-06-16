## using Css variables

> you use variables to maintain concistency across your styles

> define varibale with `--` and `variableName` like bellow example :
>
> you can define your variables in any scope , but usually in `root` with `:root` like :

```css
:root {
    --primary-color:#00000;
    --secondary-color:#11111;
}
```

> then you can use then by using `var` key word :

```css
.btn {
    background-color:var(--secondary-color);
    color:var(--primary-color);
}
```

### Using CSS Variables with Tailwind CSS

Tailwind CSS supports the use of CSS variables directly. You can define your variables in a __global__ CSS file and then reference them in your __Tailwind configuration.__

**Define CSS Variables**: First, define your CSS variables in a global CSS file.

```css
:root {
 --font-sans: "Helvetica", "Arial", sans-serif;
 --font-serif: "Georgia", "Times New Roman", serif;
}
```

```json
// tailwind.config.js
module.exports = {
 theme: {
    fontFamily: {
      sans: "var(--font-sans)",
      serif: "var(--font-serif)",
    },
 },
};
```

or using them directly in your `html` files with `tailwind` css classes like :

```html
<div class="bg-var(--my-custom-color) text-var(--my-other-color)">
  Custom-colored element
</div>
```

### remeber to put all the files you want to be compiled by `tailwind` in the `tailwind.config.js` like :

```json
/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./components/**/*.{js,ts,jsx,tsx,mdx}",
    "./app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    fontFamily: {
    sans: "var(--font-sans)",
    serif: "var(--font-serif)",
   },
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
    },
  },
  plugins: [],
};
```

because `tailwind` works by first checking for template in all those folders ( monitors them ) and them compiles them to `html`

> Overriding `Tailwind` Utility Classes  With `extend` as you see above

```json
extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
    },
```

- `"gradient-radial"`: A radial gradient using the `radial-gradient` CSS function.
- `"gradient-conic"`: A conic gradient using the `conic-gradient` CSS function.

- These custom background gradients are now available as utility classes that you can apply directly in your HTML or template files.