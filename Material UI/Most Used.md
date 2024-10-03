# MUI



- Container : used for sections `<Container sx = {{ bgcolor: "tomato", height: "100vh" }}></Container>`
- Box : is an empty div, but use `sx` prop for more
- Typography : by default is a paragraph element, can change with `variant` attribute ( prop )



> Container, Box, Typrography

### Using `SX` prop :

> ```jsx
> <Typography sx={{ m: 1, p: 1 }}
> ```
>
> a very handy way to style ( like tailwindcss classes ).
>
> like `p`, `m`, `py` , `px` , `bgcolor` , `color`, `borderRadius` , `fontSize`, > Interprets To : padding, margin, padding horizontal and vertical, respectively
>
> __8 pixel unit__



## Using `SX` prop

```jsx
<Button sx={{ color: 'white', ':hover': {bgColor: 'tomato'} }}
```

> as you can see we could even add styles for > `:hover` , `:active` , 

- `:hover`: Styles applied when the element is hovered.
- `:focus`: Styles applied when the element is focused.
- `:active`: Styles applied when the element is active (e.g., when a button is pressed).
- `:visited`: Styles applied when the element is a visited link.
- `:disabled`: Styles applied when the element is disabled.

**Pseudo-elements:**

- `::before`: Styles applied to the pseudo-element before the content.
- `::after`: Styles applied to the pseudo-element after the content.
- `::placeholder`: Styles applied to the placeholder text of an input element.

## Or using Media Queries

```css
sx={{
  '@media (max-width: 600px)': {
    width: '100%',
  },
}}
```

or You can use theme breakpoints in the `sx` prop to apply styles based on the screen size. For example:

```css
sx={{
  [theme.breakpoints.down('sm')]: {
    width: '100%',
  },
}}
```

# Example

```jsx
import Button from '@mui/material/Button';

function MyButton() {
  return (
    <Button
      sx={{
        ':hover': {
          backgroundColor: 'darkBlue',
        },
        ':focus': {
          boxShadow: '0 0 0 2px #51a7e8',
        },
        '::before': {
          content: '"Before"',
          display: 'block',
        },
        '::after': {
          content: '"After"',
          display: 'block',
        },
        '@media (max-width: 600px)': {
          width: '100%',
        },
        '& .child-element': {
          color: 'red',
        },
      }}
    >
      Click me!
    </Button>
  );
}
```

