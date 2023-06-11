import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookShopComponent } from './book-shop.component';

describe('BookShopComponent', () => {
  let component: BookShopComponent;
  let fixture: ComponentFixture<BookShopComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookShopComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookShopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
