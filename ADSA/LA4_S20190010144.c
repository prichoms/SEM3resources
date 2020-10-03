#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//------ AUTHORED BY --- PRIYAM BAJPAI ----------------------------------------//

//------ ROLL NUMBER - S20190010144 ----------------------------------------//

//----------------  RED IS 0 AND BLACK IS 1 HERE  -------------------------//



typedef struct node
{
  int data;
  struct node *right;
  struct node *left;
  struct node *dad;
  int color;
} node;

typedef struct rbtree
{
  node *root;
  node *NIL;
} rbtree;

node *new_node(int data)
{
  node *n = malloc(sizeof(node));
  n->left = NULL;
  n->right = NULL;
  n->dad = NULL;
  n->data = data;
  n->color = 0;

  return n;
}

rbtree* new_rbtree()
{
  rbtree *t = malloc(sizeof(rbtree));
  node *nil_node = malloc(sizeof(node));
  nil_node->left = NULL;
  nil_node->right = NULL;
  nil_node->dad = NULL;
  nil_node->color = 1;
  nil_node->data = 0;
  t->NIL = nil_node;
  t->root = t->NIL;

  return t;
}

void left_rotate(rbtree *t, node *x)
{
  node *y = x->right;
  x->right = y->left;
  if (y->left != t->NIL)
  {
    y->left->dad = x;
  }
  y->dad = x->dad;
  if (x->dad == t->NIL)
  { 
    t->root = y;
  }
  else if (x == x->dad->left)
  { 
    x->dad->left = y;
  }
  else
  { 
    x->dad->right = y;
  }
  y->left = x;
  x->dad = y;
}

void right_rotate(rbtree *t, node *x)
{
  node *y = x->left;
  x->left = y->right;
  if (y->right != t->NIL)
  {
    y->right->dad = x;
  }
  y->dad = x->dad;
  if (x->dad == t->NIL)
  { 
    t->root = y;
  }
  else if (x == x->dad->right)
  { 
    x->dad->right = y;
  }
  else
  { 
      x->dad->left = y;
  }
  y->right = x;
  x->dad = y;
}

void insertion_fixup(rbtree *t, node *z)
{
  while (z->dad->color == 0)
  {
    if (z->dad == z->dad->dad->left)
    { 

      node *y = z->dad->dad->right; 

      if (y->color == 0)
      { 
        z->dad->color = 1;
        y->color = 1;
        z->dad->dad->color = 0;
        z = z->dad->dad;
      }
      else
      { 
        if (z == z->dad->right)
        {                
          z = z->dad; 
          left_rotate(t, z);
        }
        
        z->dad->color = 1;       
        z->dad->dad->color = 0; 
        right_rotate(t, z->dad->dad);
      }
    }
    else
    {                                         
      node *y = z->dad->dad->left; 

      if (y->color == 0)
      {
        z->dad->color = 1;
        y->color = 1;
        z->dad->dad->color = 0;
        z = z->dad->dad;
      }
      else
      {
        if (z == z->dad->left)
        {
          z = z->dad; 
          right_rotate(t, z);
        }
        z->dad->color = 1;       
        z->dad->dad->color = 0; 
        left_rotate(t, z->dad->dad);
      }
    }
  }
  t->root->color = 1;
}

void insert(rbtree *t, node *z)
{
  node *y = t->NIL; 
  node *temp = t->root;

  while (temp != t->NIL)
  {
    y = temp;
    if (z->data < temp->data)
      temp = temp->left;
    else
      temp = temp->right;
  }
  z->dad = y;

  if (y == t->NIL)
  { 
    t->root = z;
  }
  else if (z->data < y->data) 
      y->left = z;
  else
    y->right = z;

  z->right = t->NIL;
  z->left = t->NIL;

  insertion_fixup(t, z);
}

void rb_transplant(rbtree *t, node *u, node *v)
{
  if (u->dad == t->NIL)
    t->root = v;
  else if (u == u->dad->left)
    u->dad->left = v;
  else
    u->dad->right = v;
  v->dad = u->dad;
}

node *minimum(rbtree *t, node *x)
{
  while (x->left != t->NIL)
    x = x->left;
  return x;
}



void rb_delete_fixup(rbtree *t, node *x)
{
  while (x != t->root && x->color == 1)
  {
    if (x == x->dad->left)
    {
      node *w = x->dad->right;
      if (w->color == 0)
      {
        w->color = 1;
        x->dad->color = 0;
        left_rotate(t, x->dad);
        w = x->dad->right;
      }
      if (w->left->color == 1 && w->right->color == 1)
      {
        w->color = 0;
        x = x->dad;
      }
      else
      {
        if (w->right->color == 1)
        {
          w->left->color = 1;
          w->color = 0;
          right_rotate(t, w);
          w = x->dad->right;
        }
        w->color = x->dad->color;
        x->dad->color = 1;
        w->right->color = 1;
        left_rotate(t, x->dad);
        x = t->root;
      }
    }
    else
    {
      node *w = x->dad->left;
      if (w->color == 0)
      {
        w->color = 1;
        x->dad->color = 0;
        right_rotate(t, x->dad);
        w = x->dad->left;
      }
      if (w->right->color == 1 && w->left->color == 1)
      {
        w->color = 0;
        x = x->dad;
      }
      else
      {
        if (w->left->color == 1)
        {
          w->right->color = 1;
          w->color = 0;
          left_rotate(t, w);
          w = x->dad->left;
        }
        w->color = x->dad->color;
        x->dad->color = 1;
        w->left->color = 1;
        right_rotate(t, x->dad);
        x = t->root;
      }
    }
  }
  x->color = 1;
}

void rb_delete(rbtree *t, node *z)
{
  node *y = z;
  node *x;
  int y_orignal_color = y->color;
  if (z->left == t->NIL)
  {
    x = z->right;
    rb_transplant(t, z, z->right);
  }
  else if (z->right == t->NIL)
  {
    x = z->left;
    rb_transplant(t, z, z->left);
  }
  else
  {
    y = minimum(t, z->right);
    y_orignal_color = y->color;
    x = y->right;
    if (y->dad == z)
    {
      x->dad = z;
    }
    else
    {
      rb_transplant(t, y, y->right);
      y->right = z->right;
      y->right->dad = y;
    }
    rb_transplant(t, z, y);
    y->left = z->left;
    y->left->dad = y;
    y->color = z->color;
  }
  if (y_orignal_color == 1)
    rb_delete_fixup(t, x);
}

void inorder(rbtree *t, node *n)
{
  if (n != t->NIL)
  {
    inorder(t, n->left);
    printf("%d\n", n->data);
    inorder(t, n->right);
  }
}



int main()
{
  rbtree *t = new_rbtree();
  node* arr[100];
  int i=0;
  printf("------ WELCOME ------\nPRESS 1 TO INSERT\n2 TO DELETE\n3 TO EXIT\n---------------------\n");
  int kesar;
  int key;
  while(1)
  {
  	scanf("%d",&kesar);
  	if(kesar==1)
  	{
  		printf("INSERT NODE VALUE\n\n");
  		scanf("%d",&key);
  		arr[i] = new_node(key);
  		insert(t,arr[i]);
  		i++;
		printf("DONE\n\n");
  		inorder(t, t->root);
  	}
  	else if(kesar==2)
  	{
  		printf("INSERT NODE VALUE\n\n");
  		scanf("%d",&key);
  		int p;
  		for(int j=0;j<i;j++)
  		{
  			if(arr[j]->data==key)
  			{
  				p = j;
  				break;
  			}
  		}
  		rb_delete(t,arr[p]);
		printf("DONE\n\n");
  		inorder(t, t->root);
  	}
  	else if(kesar==3)
  	{
  		exit(0);
  	}
  }
  return 0;
}

//------ AUTHORED BY --- PRIYAM BAJPAI ----------------------------------------//

//------ ROLL NUMBER - S20190010144 ----------------------------------------//