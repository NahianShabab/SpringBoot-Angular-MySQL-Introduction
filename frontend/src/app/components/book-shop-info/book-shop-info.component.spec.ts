import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookShopInfoComponent } from './book-shop-info.component';

describe('BookShopInfoComponent', () => {
  let component: BookShopInfoComponent;
  let fixture: ComponentFixture<BookShopInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookShopInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookShopInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
